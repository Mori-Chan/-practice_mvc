package examples.entity;

public class OrganizationModel {
	private String id = null;		// 組織 ID
	private String name = null;	// 組織名

	public OrganizationModel() {
		super();
	}

	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}

	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
}
