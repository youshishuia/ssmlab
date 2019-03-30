import com.lab.pojo.Form;
import com.lab.service.FormService;
import com.lab.service.impl.FormServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class textform {
    @Test
    public void findform(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        FormService formService = (FormService) context.getBean("formService");
        int a = 2;
        Form f = formService.getForm(a);
        System.out.println(f.toString());
    }
}


