package com.secnium.iast.agent.util.http;

import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

/**
 * @author dongzhiyong@huoxian.cn
 */
public class IastTrustManager implements X509TrustManager {
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[]{};
    }

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) {
    }
}
