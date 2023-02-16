package sb.sb.demosecurity.service;

import sb.sb.demosecurity.entity.Permission;

import java.util.List;

/**
 * @author Fox
 */
public interface PermissionService  {

    List<Permission> selectByUserId(Long userId);
}
