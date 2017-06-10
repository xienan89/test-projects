package com.autonavi.tinfo;

import org.xlightweb.*;

import java.io.IOException;

/**
 * Created by xienan.xn
 *
 * @date 2016/8/17 10:01
 */
public class XlightWebHandler implements IHttpRequestHandler {
    @Override
    public void onRequest(IHttpExchange iHttpExchange) throws IOException, BadMessageException {
        StringBuilder sb = new StringBuilder(100000);
        for (int i = 0; i < 1000000; i++) {
            sb.append('A');
        }

        IHttpResponse iHttpResponse = new HttpResponse(sb.toString());
        iHttpExchange.send(iHttpResponse);
    }
}
