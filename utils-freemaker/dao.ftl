import java.util.List;
import java.util.Map;

import ${packageName}.model.${ModelName};
import com.ebaoyang.dao.MyBatisRepository;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@MyBatisRepository
public interface ${ModelName}Dao {
	String FIELDS = " id<#list fieds as f>,${f.column} </#list> ";
	
	@Insert("insert into ${tableName}(<#list fieds as f><#if f_index gt 0 >,</#if>${f.column}</#list>) values(<#list fieds as f><#if f_index gt 0 >,</#if>${SPTJ}{${f.field}}</#list>)")	
	@Options(useGeneratedKeys=true,keyColumn="id",keyProperty="id")
	public void add${ModelName}(${ModelName} ${modelName});

	@Select("select " + FIELDS + " from ${tableName} where id = ${SPTJ}{id}")
	public ${ModelName} get${ModelName}(int id);

	@Select("update ${tableName} set <#list fieds as f><#if f_index gt 0 >,</#if>${f.column}=${SPTJ}{${f.field}}</#list> where id=${SPTJ}{id}")
	public void update${ModelName}(${ModelName} ${modelName});

	@Select("delete from ${tableName} where	id=${SPTJ}{id}")
	public void delete${ModelName}(int id);
}
