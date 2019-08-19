package com.jiaxin.dream.utils;

import com.alibaba.fastjson.JSONObject;

public class RSAEncryptDateDemo {

    //渠道端私钥
    private static final String clientPrivateKey = "MIICXAIBAAKBgQCn7LMBkPuDbmr18Z9ND5k6CjFsQeTm++vJNoiJp2tOLyb7LOV4\n"
        + "uyFlEE8jdS584O8xFmqaKnFabS1lnatAmlAZJI7gO5mrIIGu1HT9I10ZzVgkC4TE\n"
        + "CM6chj5zmUMVVPFAjVk0DFzLjq//1ClDP2aCHECFr1BdDn8hnhg8yUxobwIDAQAB\n"
        + "AoGAE2wRGDFIpd7ziBa2MheHxWrAZKEKdJzWnKMuD53Jj3VssMh0kg4ywpmsTZGU\n"
        + "GuV5RNgu5D3cdnUCNyqRUBuI/+95CadK/fLJg+ahGqUnNz74+29yjKLmxoA+dQJj\n"
        + "MGTqs8nkhdvKOwMkh2cltrNHiI4GmKnTcN3/R8nuPb6xdoECQQDWlOnpCTsgw93k\n"
        + "3y0qizK6O5D7sePwIfvmiZ8v6KmHewyg+ew94CjANpcXwH9Gxui6uas/+GmRAKpT\n"
        + "5PVZlfm/AkEAyFZTy5XMnLylBqbtE17KXHWE3NOu369qwU/fmH5llbL4dm0RfSiD\n"
        + "jcfP0obUJhL5Pm5yIR8fE5OdeuZsJmJdUQJAXOfWqr4DarlDHm/+Zzgje3yE1mT7\n"
        + "8qFUJkmZsa2DkRQWsK/kuBmQq0A3hOIkeSlv5EC1Q5ozYsOt+2rbS7FikwJBALWO\n"
        + "TriE1H8DE0eZBed1E02Bj1wVVzkOn1/7w/ZOLj/hhvzEUYIssjRObdAsMp0iutDS\n"
        + "hQnxS1eRgrl7k22h3VECQFOdzzGdsbf0fbAzreXlK/5ZIDWqR0L6KJXCR7gDydzr\n"
        + "+ZoRFJXaF7H7sxZgAx0/YmjwzTuDanxLPzz2eBi7Wao=";
    //渠道端私钥
    private static final String clientPrivateKey2 = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKfsswGQ+4NuavXx\n"
        + "n00PmToKMWxB5Ob768k2iImna04vJvss5Xi7IWUQTyN1Lnzg7zEWapoqcVptLWWd\n"
        + "q0CaUBkkjuA7masgga7UdP0jXRnNWCQLhMQIzpyGPnOZQxVU8UCNWTQMXMuOr//U\n"
        + "KUM/ZoIcQIWvUF0OfyGeGDzJTGhvAgMBAAECgYATbBEYMUil3vOIFrYyF4fFasBk\n"
        + "oQp0nNacoy4PncmPdWywyHSSDjLCmaxNkZQa5XlE2C7kPdx2dQI3KpFQG4j/73kJ\n"
        + "p0r98smD5qEapSc3Pvj7b3KMoubGgD51AmMwZOqzyeSF28o7AySHZyW2s0eIjgaY\n"
        + "qdNw3f9Hye49vrF2gQJBANaU6ekJOyDD3eTfLSqLMro7kPux4/Ah++aJny/oqYd7\n"
        + "DKD57D3gKMA2lxfAf0bG6Lq5qz/4aZEAqlPk9VmV+b8CQQDIVlPLlcycvKUGpu0T\n"
        + "XspcdYTc067fr2rBT9+YfmWVsvh2bRF9KIONx8/ShtQmEvk+bnIhHx8Tk5165mwm\n"
        + "Yl1RAkBc59aqvgNquUMeb/5nOCN7fITWZPvyoVQmSZmxrYORFBawr+S4GZCrQDeE\n"
        + "4iR5KW/kQLVDmjNiw637attLsWKTAkEAtY5OuITUfwMTR5kF53UTTYGPXBVXOQ6f\n"
        + "X/vD9k4uP+GG/MRRgiyyNE5t0CwynSK60NKFCfFLV5GCuXuTbaHdUQJAU53PMZ2x\n"
        + "t/R9sDOt5eUr/lkgNapHQvoolcJHuAPJ3Ov5mhEUldoXsfuzFmADHT9iaPDNO4Nq\n"
        + "fEs/PPZ4GLtZqg==";


    private static final String clientpublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCn7LMBkPuDbmr18Z9ND5k6CjFs\n"
        + "QeTm++vJNoiJp2tOLyb7LOV4uyFlEE8jdS584O8xFmqaKnFabS1lnatAmlAZJI7g\n"
        + "O5mrIIGu1HT9I10ZzVgkC4TECM6chj5zmUMVVPFAjVk0DFzLjq//1ClDP2aCHECF\n"
        + "r1BdDn8hnhg8yUxobwIDAQAB";


    //睿智测试公钥
	private static final String ruizhiPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCUEOuuvzFO1kd93JtUA6FcjR34" +
			"dN8yqchEKnZ5kwGUdZyPo5p8koaTjrlmD8po7kTvScS8gYCZgbMCxBFtvsMBi53V" +
			"glo+BVvd/rYUGQVr7ZUsFHDIUc7vrcBYmYmrUhrQ+wmA/KfaqMEWolqJVCoZisi3" +
			"bry5MP2bdH1Hnf72YwIDAQAB";

   /* private static final String ruizhiPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCoNRpgn4c48aSDJpSI3S/n8YVx\n"
        + "70OlzR/G2w3LHnULqXLyUdiHzBddC2LT5k0isPFFaxl41TNZDW8sEFJ1nxY/Fw/v\n"
        + "dnMfBJ9oKW2y7LsnzfhyXflx4neuk6lleLLINma1AJVkKO8Oc54iDWxJvQcTXS9y\n"
        + "fmY6pBrC/5/8UN7QvwIDAQAB";*/

    /*private static final String ruizhiPrivatecKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKg1GmCfhzjxpIMm\n"
        + "lIjdL+fxhXHvQ6XNH8bbDcsedQupcvJR2IfMF10LYtPmTSKw8UVrGXjVM1kNbywQ\n"
        + "UnWfFj8XD+92cx8En2gpbbLsuyfN+HJd+XHid66TqWV4ssg2ZrUAlWQo7w5zniIN\n"
        + "bEm9BxNdL3J+ZjqkGsL/n/xQ3tC/AgMBAAECgYA1tr91m3vS81dVijxkeD2UE8xJ\n"
        + "Vd6EU7ySA+Gju1YlIzdRqlE7DDFpxPkKMcDwExD42fqIW4zKI0AdEhlC9kpj1qPt\n"
        + "d5eurR6d/rdutlQdDPYtiBY6qGbjNjXTdyfHzWBEVAVlB7xUB4lZ+bgI10qya6gq\n"
        + "GYV2WuoAnqyzaNPmAQJBANVtxgbx9wsV47vTbmnVfsGJDiSnDap+OEJuMRItIqQO\n"
        + "p91N164sgvl4Ro8BItflsPoSicFN4/vQiMT6aIDLylUCQQDJwjWf+tEEVbYsXKXP\n"
        + "lZHwzJ718tjiOxTiiigbbJuG5MCPMn8CknMpJwNiA8f6z9i4Hv3bC55JKpNe4zQJ\n"
        + "6urDAkEAvxkjDmTohgx7dFnDqw92B2PoPfk1y0popVJ0rYmsUqistQJV86X3P9fp\n"
        + "lXG2+Qi4hbDDl0lesMHvNC/iEjBmYQJAHIzo/byGe3CNmPV7WUa3IjYygGdfHZRy\n"
        + "viQCzO6vi4UvYpQouPp0ZWxp5CLY17s11cg88BRSz9PAivrn0Ed39QJBAIrV0y2u\n"
        + "x5KF3RLP4yGn8fRcsBZhgqaPZdpekd3Wo59+/2g+a/A9011sHDuaVpMI5EhGzfnA\n"
        + "QYZ8bOJ/DO2DzNk=";*/

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
		/*String clientID = "meic001";
		String mobile = "18237151910";
		String timestamp = String.valueOf(System.currentTimeMillis());//13位毫秒时间搓
		
		String encMobile = RSAUtils.(encryptByPublicKeymobile+timestamp, ruizhiPublicKey);
		String sign = RSAUtils.signByPrivateKey(mobile+timestamp, clientPrivateKey, "utf-8");
		System.out.println("encMobile:"+encMobile);
		System.out.println("mobile:"+encMobile);*/
        String jsonStr = "{\"dataType\":\"2\",\"mobile\":\"15812312314\",\"orderInfo\":{\"blance\":8000.00,\"termArray\":[{\"needRepayDate\":\"2020-08-16\",\"repayPrincipal\":\"8761.54\",\"interest\":\"131.42\",\"repayAmount\":\"8892.96\",\"term\":\"12\",\"status\":\"1\"}],\"repayTotalAmount\":9000.00,\"totalPrincipal\":9000.00,\"wiseUserId\":\"16000030191\",\"productName\":\"哈银有卡贷-挡板\",\"wiseApplyID\":\"100016658358\",\"userLoanID\":\"20192516184444\",\"productCode\":\"HRBBMB-CL0001\",\"borrow\":9000.00,\"withdrawDate\":\"2019-08-16 09:34:46\",\"status\":2,\"termNum\":6}}";
        /*String encData = RSAUtils.encryptByPublicKey(jsonStr, clientpublicKey);
        String sign = RSAUtils.signByPrivateKey(encData, ruizhiPrivatecKey, "utf-8");
        System.out.println("encData=" + encData );
        System.out.println("sign=" +sign);
        System.out.println("================================");
        boolean result = RSAUtils.verifyByPublicKey(encData, ruizhiPublicKey, sign, "utf-8");
        System.out.println("result="+result);
        String decData = RSAUtils.decryptByPrivateKey(encData, clientPrivateKey2);
        System.out.println("decData="+decData);*/

    /*    String sign = RSAUtils.signByPrivateKey(jsonStr, clientPrivateKey2, "utf-8");
        System.out.println("sign=" +sign);*/
    /*    String encData = "PDbKqDrIcZbVzLATiiy/lXh3zBBa605F3cMyIVSBAQtprYgDKuq7zWcHmiEgUj3/yuh7hhSYOo5elkC8bD9bPjZvYZQx4nM+RZYRFDIp7+2C56o+1c2Gfd0mvjeKTc1XhAck55AbI0U474eQaZg9vfURVmTCa04yGMkmI4+uhi0=";
        String sign = "Q81YvfjeJQmMgSAiPkcfeosnWY0USd+S92xrKbBEJ0vFVt0jVtuJtcne7gAwY4v0tyT7ThzL1JGERNAsDB2AVe8CUjMVKMkGj2ZTfeUtYWr/Mx2VvzUgIvoHU+VWTr3kpwFPAHpcPitiq+hOXZ4MFw1+pTopy81WGr2c8xxzUFg=";
        boolean result = RSAUtils.verifyByPublicKey(encData, clientpublicKey, sign, "utf-8");
        System.out.println("result="+result);*/

        String decData = RSAUtils.encryptByPublicKey(jsonStr, clientpublicKey);
        System.out.println(decData);
    }

}
//    //渠道端私钥
//    private static final String clientPrivateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKfsswGQ+4NuavXx\n"
//        + "n00PmToKMWxB5Ob768k2iImna04vJvss5Xi7IWUQTyN1Lnzg7zEWapoqcVptLWWd\n"
//        + "q0CaUBkkjuA7masgga7UdP0jXRnNWCQLhMQIzpyGPnOZQxVU8UCNWTQMXMuOr//U\n"
//        + "KUM/ZoIcQIWvUF0OfyGeGDzJTGhvAgMBAAECgYATbBEYMUil3vOIFrYyF4fFasBk\n"
//        + "oQp0nNacoy4PncmPdWywyHSSDjLCmaxNkZQa5XlE2C7kPdx2dQI3KpFQG4j/73kJ\n"
//        + "p0r98smD5qEapSc3Pvj7b3KMoubGgD51AmMwZOqzyeSF28o7AySHZyW2s0eIjgaY\n"
//        + "qdNw3f9Hye49vrF2gQJBANaU6ekJOyDD3eTfLSqLMro7kPux4/Ah++aJny/oqYd7\n"
//        + "DKD57D3gKMA2lxfAf0bG6Lq5qz/4aZEAqlPk9VmV+b8CQQDIVlPLlcycvKUGpu0T\n"
//        + "XspcdYTc067fr2rBT9+YfmWVsvh2bRF9KIONx8/ShtQmEvk+bnIhHx8Tk5165mwm\n"
//        + "Yl1RAkBc59aqvgNquUMeb/5nOCN7fITWZPvyoVQmSZmxrYORFBawr+S4GZCrQDeE\n"
//        + "4iR5KW/kQLVDmjNiw637attLsWKTAkEAtY5OuITUfwMTR5kF53UTTYGPXBVXOQ6f\n"
//        + "X/vD9k4uP+GG/MRRgiyyNE5t0CwynSK60NKFCfFLV5GCuXuTbaHdUQJAU53PMZ2x\n"
//        + "t/R9sDOt5eUr/lkgNapHQvoolcJHuAPJ3Ov5mhEUldoXsfuzFmADHT9iaPDNO4Nq\n"
//        + "fEs/PPZ4GLtZqg==";
//
//    //睿智测试公钥
//    private static final String ruizhiPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCUEOuuvzFO1kd93JtUA6FcjR34" +
//        "dN8yqchEKnZ5kwGUdZyPo5p8koaTjrlmD8po7kTvScS8gYCZgbMCxBFtvsMBi53V" +
//        "glo+BVvd/rYUGQVr7ZUsFHDIUc7vrcBYmYmrUhrQ+wmA/KfaqMEWolqJVCoZisi3" +
//        "bry5MP2bdH1Hnf72YwIDAQAB";
