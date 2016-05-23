package com.xienan.nio.nioserver.event;

import com.xienan.nio.nioserver.Request;
import com.xienan.nio.nioserver.Response;

/**
 * <p>Title: �������¼�������</p>
 * @author starboy
 */

public interface ServerListener {

   /**
    * ������˴���������ʱ�������¼�
    * @param error ������Ϣ
    */
   public void onError(String error);

   /**
    * ���пͻ��˷�4����ʱ�������¼�
    */
   public void onAccept() throws Exception;

   /**
    * ������˽��ܿͻ�������󴥷����¼�
    * @param request �ͻ�������
    */
   public void onAccepted(Request request) throws Exception;

   /**
    * ���ͻ��˷�4��ݣ����ѱ�����������߳���ȷ��ȡʱ���������¼�
    * @param request �ͻ�������
    */
   public void onRead(Request request) throws Exception;

   /**
    * ��������ͻ��˷������󴥷����¼�
    * @param request �ͻ�������
    */
   public void onWrite(Request request, Response response) throws Exception;

   /**
    * ���ͻ�������������l�Ӻ󴥷����¼�
    * @param request �ͻ�������
    */
   public void onClosed(Request request) throws Exception;
}
