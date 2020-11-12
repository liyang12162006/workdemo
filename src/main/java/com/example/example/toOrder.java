package com.example.example;


/**
 * @author yangyangl
 * @date 2018-09-11 11:17
 */
public class toOrder {

//    static Order mockOrder() {
//        Order order = JsonUtils.readValue("{\n" +
//                "    \"orderNo\": 101032000855,\n" +
//                "    \"mainOrder\": {\n" +
//                "        \"version\": 15,\n" +
//                "        \"orderBase\": {\n" +
//                "            \"orderNo\": 101032000855,\n" +
//                "            \"orderStatus\": \"NEW_ORDER\",\n" +
//                "            \"checkInDate\": {\n" +
//                "                \"year\": 2017,\n" +
//                "                \"month\": 9,\n" +
//                "                \"day\": 6\n" +
//                "            },\n" +
//                "            \"checkOutDate\": {\n" +
//                "                \"year\": 2017,\n" +
//                "                \"month\": 9,\n" +
//                "                \"day\": 7\n" +
//                "            },\n" +
//                "            \"orderDate\": 1504699022901,\n" +
//                "            \"hotelId\": 1,\n" +
//                "            \"hotelName\": \"门测试1\",\n" +
//                "            \"unitId\": 500000,\n" +
//                "            \"unitName\": \"房屋测试1\",\n" +
//                "            \"cityId\": 48,\n" +
//                "            \"userId\": 45566,\n" +
//                "            \"linkMan\": \"张d华\",\n" +
//                "            \"linkMobile\": \"18600631874\",\n" +
//                "            \"linkEmail\": \"yaohuaz@tujia.com\",\n" +
//                "            \"peopleCountDetail\": {\n" +
//                "                \"adultCount\": 2,\n" +
//                "                \"childCount\": 0\n" +
//                "            },\n" +
//                "            \"unitBookingType\": 2,\n" +
//                "            \"totalAmount\": {\n" +
//                "                \"amount\": 343,\n" +
//                "                \"currency\": \"CNY\"\n" +
//                "            },\n" +
//                "            \"prepayAmount\": {\n" +
//                "                \"amount\": 343,\n" +
//                "                \"currency\": \"CNY\"\n" +
//                "            },\n" +
//                "            \"productId\": 9000001,\n" +
//                "            \"productName\": \"基础价\",\n" +
//                "            \"bookingCount\": 1,\n" +
//                "            \"depositStrategy\": {\n" +
//                "                \"depositAmount\": 0.01,\n" +
//                "                \"depositType\": 0,\n" +
//                "                \"supportCreditFreeDeposit\": 1,\n" +
//                "                \"freeDepositType\": 1\n" +
//                "            }\n" +
//                "        },\n" +
//                "        \"orderControl\": {\n" +
//                "            \"payCloseTime\": 1504702022902,\n" +
//                "            \"needRoolbackInventory\": false,\n" +
//                "            \"visibleRoles\": [\n" +
//                "                \"TUJIA\",\n" +
//                "                \"HOTEL\"\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        \"orderProduct\": {\n" +
//                "            \"orderProductBase\": {\n" +
//                "                \"commissionType\": 1,\n" +
//                "                \"commissionRate\": 0.0,\n" +
//                "                \"payType\": 1,\n" +
//                "                \"saleType\": 2,\n" +
//                "                \"priceType\": 1,\n" +
//                "                \"product\": {\n" +
//                "                    \"currencyUnit\": 1,\n" +
//                "                    \"exchangeRateToRMB\": 1,\n" +
//                "                    \"exchangeRateToUSD\": 1,\n" +
//                "                    \"orderCancelRule\": {\n" +
//                "                        \"cancelable\": true,\n" +
//                "                        \"preDays\": 1,\n" +
//                "                        \"fineType\": 1,\n" +
//                "                        \"fineAmount\": 1\n" +
//                "                    }\n" +
//                "                },\n" +
//                "                \"hotel\": {\n" +
//                "                    \"landLordId\": 1,\n" +
//                "                    \"landLordName\": \"刘要华\",\n" +
//                "                    \"hotelSourceType\": 0,\n" +
//                "                    \"hotelType\": 3,\n" +
//                "                    \"hotelOwnerId\": 10000,\n" +
//                "                    \"cityName\": \"北京\",\n" +
//                "                    \"cityId\": 48,\n" +
//                "                    \"enumSharingType\": 0\n" +
//                "                }\n" +
//                "            },\n" +
//                "            \"orderDayRate\": {\n" +
//                "                \"orderNo\": 101032000855,\n" +
//                "                \"unitId\": 500000,\n" +
//                "                \"productId\": 9000001,\n" +
//                "                \"dayRateRecords\": [{\n" +
//                "                    \"day\": {\n" +
//                "                        \"year\": 2017,\n" +
//                "                        \"month\": 9,\n" +
//                "                        \"day\": 6\n" +
//                "                    },\n" +
//                "                    \"unitRate\": 343,\n" +
//                "                    \"unitRateBase\": 0,\n" +
//                "                    \"hwRate\": 343,\n" +
//                "                    \"hwRateBase\": 0,\n" +
//                "                    \"currencyUnit\": 1\n" +
//                "                }]\n" +
//                "            }\n" +
//                "        },\n" +
//                "        \"orderExtension\": {\n" +
//                "            \"clientID\": 0,\n" +
//                "            \"createOperator\": \"18600631874\",\n" +
//                "            \"sellChannelType\": 1,\n" +
//                "            \"createOrderIP\": \"10.2.21.89\",\n" +
//                "            \"kaInfo\": {\n" +
//                "                \"kaCustomerID\": 12,\n" +
//                "                \"kaEmployeeID\": 189447\n" +
//                "            },\n" +
//                "            \"customerSourceType\": 1,\n" +
//                "            \"orderPreferential\": {\n" +
//                "                \"grantStatus\": 0,\n" +
//                "                \"preferentialRecords\": [{\n" +
//                "                    \"promoClass\": 1,\n" +
//                "                    \"promoSourceType\": 20,\n" +
//                "                    \"amount\": 34,\n" +
//                "                    \"createTime\": 1504699023157\n" +
//                "                }, {\n" +
//                "                    \"promoClass\": 0,\n" +
//                "                    \"promoSourceType\": 30,\n" +
//                "                    \"amount\": 20,\n" +
//                "                    \"createTime\": 1504699023157\n" +
//                "                }, {\n" +
//                "                    \"promoClass\": 2,\n" +
//                "                    \"promoSourceType\": 40,\n" +
//                "                    \"amount\": 343,\n" +
//                "                    \"rate\": 100,\n" +
//                "                    \"createTime\": 1504699023157\n" +
//                "                }]\n" +
//                "            },\n" +
//                "            \"userMobile\": \"18600631874\",\n" +
//                "            \"userName\": \"张要d华\",\n" +
//                "            \"orderExtra\": {\n" +
//                "                \"oldOrderId\": 100018091\n" +
//                "            },\n" +
//                "            \"cookieRecord\": \"{\\\"tujia_code\\\":\\\"\\\",\\\"tujia_code_site\\\":\\\"\\\",\\\"tujia_out_site_landingUrl\\\":\\\"\\\",\\\"tujia_out_site_\\\":\\\"\\\",\\\"tujia_utm\\\":\\\"\\\"}\",\n" +
//                "            \"orderInsurence\": {\n" +
//                "                \"insurenceCount\": 1\n" +
//                "            }\n" +
//                "        }\n" +
//                "    },\n" +
//                "    \"payOrder\": {\n" +
//                "        \"version\": 14,\n" +
//                "        \"orderNo\": 101032000855,\n" +
//                "        \"payAmount\": 343.0000,\n" +
//                "        \"realPayAmount\": 54.0000,\n" +
//                "        \"paymentNumber\": \"20170906100008556090\",\n" +
//                "        \"payRecords\": [{\n" +
//                "            \"transactionId\": \"20170906110008552571\",\n" +
//                "            \"paidAmount\": 34,\n" +
//                "            \"paymentType\": \"TJ_REDUCE\",\n" +
//                "            \"payStatus\": \"PAY_SUCCESS\"\n" +
//                "        }, {\n" +
//                "            \"transactionId\": \"20170906110008554786\",\n" +
//                "            \"paidAmount\": 20,\n" +
//                "            \"paymentType\": \"TJ_REDPACKAGE\",\n" +
//                "            \"payStatus\": \"PAY_SUCCESS\"\n" +
//                "        }],\n" +
//                "        \"payStatus\": \"UNPAID\"\n" +
//                "    },\n" +
//                "    \"version\": 16,\n" +
//                "    \"createTime\": 1504698835000,\n" +
//                "    \"updateTime\": 1510316953000\n" +
//                "}", Order.class);
//        order
//    }
}
