package sb.sb.demosecurity.mapper;

import sb.sb.demosecurity.entity.User;

/**
 * @author ：lixiangyu
 * @title: UserMapper
 * @projectName demo-security
 * @description：TODO
 * @date ：2023-02-15 23:19
 */
public interface UserMapper {

    User getByUsername(String username);

}
