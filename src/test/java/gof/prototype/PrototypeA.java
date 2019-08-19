package gof.prototype;

/**
 * <p>
 *
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/8/11 18:43
 */
public class PrototypeA implements Cloneable {

    private String name;

    public PrototypeA(String name) {
        this.name = name;
    }

    @Override
    protected PrototypeA clone() throws CloneNotSupportedException {
        return (PrototypeA) super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name:" + getName();
    }
}
