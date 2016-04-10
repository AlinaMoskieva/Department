package ru.itis.inform.department.dao.jdbc;

import java.util.List;
import java.util.Map;

/**
 * Created by Moskieva on 09.04.16.
 */
public interface ParamsMapper {
    Map<String, Object> asMap(List<String> keys, List<?> values);
}
