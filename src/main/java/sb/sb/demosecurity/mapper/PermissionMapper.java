package sb.sb.demosecurity.mapper;

import sb.sb.demosecurity.entity.Permission;

import java.util.List;

public interface PermissionMapper {

    List<Permission> selectByUserId(Integer id);
}
