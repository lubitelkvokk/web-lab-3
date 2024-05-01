package weblab3.util;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.servlet.ServletContextListener;
import lombok.experimental.UtilityClass;

import javax.management.*;
import java.lang.management.ManagementFactory;


public class ManagementUtil implements ServletContextListener {

    public ManagementUtil(){
    }

    public static void registerBean(Object bean) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {

        System.out.println("MANAGEMENT BEAN INITIALIZING");
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        String domain = bean.getClass().getPackageName();
        String type = bean.getClass().getSimpleName();
        ObjectName objectName = new ObjectName(String.format("%s:type=%s,name=%s", domain, type, bean.getClass().getSimpleName()));

        mbs.registerMBean(bean, objectName);
    }
//
//    public void unregisterBean(Object o) throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, InstanceNotFoundException {
//        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
//        mbs.unregisterMBean(new ObjectName(o.getClass().getCanonicalName()));
//    }

}
