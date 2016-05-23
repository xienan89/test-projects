import java.util.List;
import java.util.Map;

import ${packageName}.model.${ModelName};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ${ModelName}Service {

	@Autowired
	private ${ModelName}Dao ${modelName}Dao;

	public void add${ModelName}(${ModelName} ${modelName}){
		${modelName}Dao.add${ModelName}(${modelName});
	}

	public ${ModelName} get${ModelName}(int id){
		return ${modelName}Dao.get${ModelName}(id);
	}

	public void update${ModelName}(${ModelName} ${modelName}){
		${modelName}Dao.update${ModelName}(${modelName});
	}

	public void delete${ModelName}(int id){
		${modelName}Dao.delete${ModelName}(id);
	}
}
