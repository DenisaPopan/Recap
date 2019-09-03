package P1;

import org.springframework.beans.BeanUtils;
import java.beans.PropertyDescriptor;

public class Main {
    public static void main(String[] args) {
        System.out.println("Chair: " + getRatioBetweenSimpleAndComplexClassProperties(Chair.class));
        System.out.println("Table: " + getRatioBetweenSimpleAndComplexClassProperties(Table.class));
        System.out.println("Furniture: " + getRatioBetweenSimpleAndComplexClassProperties(Furniture.class));
    }

    public static double getRatioBetweenSimpleAndComplexClassProperties(Class classType){
        double numberOfSimpleProperties = 0;
        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(classType);
        for(PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            if(BeanUtils.isSimpleProperty(propertyDescriptor.getPropertyType())){
                numberOfSimpleProperties++;
            }
        }
        numberOfSimpleProperties--; //Scadem proprietatea Class
        return numberOfSimpleProperties/(propertyDescriptors.length - 1);
    }
}
