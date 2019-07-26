package EntityClassesPackage;

public class Category {
private int catId;
private String cate_name;
public Category(int catId, String cate_name) {
	super();
	this.catId = catId;
	this.cate_name = cate_name;
}
public Category() {
	super();
	// TODO Auto-generated constructor stub
}
public int getCatId() {
	return catId;
}
public void setCatId(int catId) {
	this.catId = catId;
}
public String getCate_name() {
	return cate_name;
}
public void setCate_name(String cate_name) {
	this.cate_name = cate_name;
}
@Override
public String toString() {
	return "Category [catId=" + catId + ", cate_name=" + cate_name + "]";
}

}
