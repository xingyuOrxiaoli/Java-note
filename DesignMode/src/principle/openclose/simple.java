package principle.openclose;


interface ICourse{

    Integer getId();
    String getName();
    Double getPrice();
}
class JavaCourseImpl implements ICourse{

    private Integer id;
    private String name;
    private Double price;
    public JavaCourseImpl(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}

class JavaDiscountCourseImpl extends JavaCourseImpl{

    public JavaDiscountCourseImpl(Integer id, String name, Double price) {
        super(id, name, price);
    }

    public Double getDisCountPrice() {
        return super.getPrice() * 0.5; // 这里设置打五折
    }
}

public class simple {

}
