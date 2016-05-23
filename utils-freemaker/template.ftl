<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="${packageName}.dao.${ModelName}Dao">
	<resultMap type="${ModelName}" id="T${modelName}">
		<id column="id" property="id" />
		<#list fieds as f>
		<result column="${f.column}" property="${f.field}" />
		</#list>
	</resultMap>
	
	<sql id = "Columns">
		<#list fieds as f>,${f.column}</#list>
	</sql>
	<select id="get${ModelName}" parameterType="int" resultMap="T${modelName}">
		select
		id
			<include refid="Columns" />
		 from ${tableName} where id = ${SPTJ}{id}
	</select>
	
	<insert id="add${ModelName}" parameterType="${ModelName}" useGeneratedKeys="true" keyProperty="id">
		insert into
		${tableName}(<#list fieds as f><#if f_index gt 0 >,</#if>${f.column}</#list>)
		values(<#list fieds as f><#if f_index gt 0 >,</#if>${SPTJ}{${f.field}}</#list>)
	</insert>
	
	<update id="update${ModelName}" parameterType="${ModelName}">
		update ${tableName} set
		<#list fieds as f><#if f_index gt 0 >,</#if>${f.column}=${SPTJ}{${f.field}}</#list>
		where id=${SPTJ}{id}
	</update>
	
	<delete id="delete${ModelName}" parameterType="int">
		delete from ${tableName} where
		id=${SPTJ}{id}
	</delete>
	
</mapper>