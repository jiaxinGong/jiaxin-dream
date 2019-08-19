package com.jiaxin.dream.utils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * bean convert
 *
 */
public class BeanConvertUtil {
	
	/**
	 * 获取bean内属性列表（bean -> map）
	 * @param obj
	 * @param ignoreNullFieldValue
	 * @return Map &lt;fieldName, fieldValue&gt;
	 */
	public static Map<String, Object> convertBean2Map(Object obj, boolean ignoreNullFieldValue) {

		Map<String, Object> fieldMap = Maps.newHashMap();
		try {
			// 获取bean属性
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass(), Object.class);

			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			System.out.println("propertyDescriptors="+JSON.toJSONString(propertyDescriptors));
			if (propertyDescriptors != null && propertyDescriptors.length > 0) {
				for (PropertyDescriptor pd : propertyDescriptors) {
					String propertyName = pd.getName();
					if (!"class".equals(propertyName)) {
						Method readMethod = pd.getReadMethod();
						Object propertyValue = readMethod.invoke(obj);
						if (ignoreNullFieldValue && null == propertyValue) {
							continue;
						}
						fieldMap.put(propertyName, propertyValue);
					}
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| IntrospectionException e) {
			throw new RuntimeException("javabean convert to map error.", e);
		}
		return fieldMap;
	}

	/**
	 * 拷贝需要/指定的值
	 * @param oldObj
	 * @param valueNames
	 */
	private <T> T copyNeedValue(T oldObj, Set<String> valueNames) {
		if (Objects.isNull(oldObj) || CollectionUtils.isEmpty(valueNames)) {
			return null;
		}
		try {
			BeanMap beanMap = new org.apache.commons.beanutils.BeanMap(oldObj);
			Map<String, Object> mapResult = new HashMap<>();
			beanMap.forEach((k, v) -> {
				if (valueNames.contains(k.toString())) {
					mapResult.put(k.toString(), v);
				}
			});
			T newObj = (T) oldObj.getClass().newInstance();
			org.apache.commons.beanutils.BeanUtils.populate(newObj, mapResult);
			return newObj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oldObj;
	}
}
