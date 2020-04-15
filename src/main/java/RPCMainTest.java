import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import javax.xml.namespace.QName;

/**RPC CLIENT TEST PROGRAM*/
public class RPCMainTest {
    public static void main(String args[]) throws Throwable{
        //指定getInfo方法的参数值
        Object[] addArgs1 = new Object[] {"刘翔",234};
        sampletest("http://localhost:8081/axis2/services/SampleService?wsdl","http://ws.apache.org/axis2","getName",addArgs1);
        Object[] addArgs2 = new Object[] {234};
        sampletest("http://localhost:8081/axis2/services/ServService?wsdl","http://java.ws.com","fly",addArgs2);
    }

    private static void sampletest(String url,String namespace,String method,Object[] addArgs) throws Throwable{
        RPCServiceClient serviceClient=new RPCServiceClient();
        EndpointReference er=new EndpointReference(url);
        Options options=serviceClient.getOptions();
        options.setTo(er);

        //指定方法返回值数据类型的class对象
        Class[] classs = new Class[] {String.class};

        //指定wsdl文件的命名空间及要调用的方法，命名空间为通过浏览器打开wsdl文件，看到的元素targetNamespace的属性值
        QName qname = new QName(namespace,method);

        System.out.println(serviceClient.invokeBlocking(qname, addArgs, classs)[0]);
    }
}
