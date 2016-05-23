public class ${ModelName} {
	private int id;
	<#list fieds as f>
	private String ${f.field};
	</#list>
	
	@Override
	public String toString(){
		String s = "id:" + id + ", " + 
		<#list fieds as f>
			"${f.field}:" + ${f.field} + ", " +
		</#list> "";
		return "[" + s + "]";
	}
}
