package com.example.utils;

import com.huitongjy.common.util.LogUtils;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import lombok.extern.slf4j.Slf4j;

/**
 * Net Work Utils
 *
 * @author zhaoke
 * @since 2020/3/23
 **/
@Slf4j
public class NetWorkUtils {

    private static final String LOOK_BACK_ADDRESS = "127.0.0.1";

    public static String getLocalHostname() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            LogUtils.error(log, "get local hostname failed. return local ip instead.", "error info", e.getMessage());
            return getLocalAddress();
        }
    }

    public static String getLocalAddress() {
        try {
            final Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            final ArrayList<String> ipv4Result = new ArrayList<>();
            final ArrayList<String> ipv6Result = new ArrayList<>();
            while (interfaces.hasMoreElements()) {
                final NetworkInterface networkInterface = interfaces.nextElement();
                if (!networkInterface.isUp()) {
                    continue;
                }
                if (networkInterface.isVirtual()) {
                    continue;
                }
                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    final InetAddress address = addresses.nextElement();
                    if (!address.isLoopbackAddress()) {
                        if (address instanceof Inet6Address) {
                            ipv6Result.add(address.getHostAddress());
                        } else {
                            ipv4Result.add(address.getHostAddress());
                        }
                    }
                }
            }
            if (!ipv4Result.isEmpty()) {
                for (String ip : ipv4Result) {
                    if (ip.startsWith("127.0")) {
                        continue;
                    }
                    return ip;
                }
                return ipv4Result.get(ipv4Result.size() - 1);
            } else if (!ipv6Result.isEmpty()) {
                return ipv6Result.get(0);
            }
            return InetAddress.getLocalHost().getHostAddress();

        } catch (Exception e) {
            LogUtils.error(log, "get local address failed", "error info", e.getMessage());
        }
        return LOOK_BACK_ADDRESS;
    }
}
