package cn.tangzy.oauth2.dao.user;

import cn.tangzy.oauth2.entity.user.User;
import cn.tangzy.oauth2.entity.user.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String username);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String username);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    User findByUsernameCaseInsensitive(@Param("username") String username);

    User findByEmail(@Param("email") String email);

    User findByEmailAndActivationKey(@Param("email") String email, @Param("activationKey") String activationKey);

    User findByEmailAndResetPasswordKey(@Param("email") String email, @Param("resetPasswordKey") String resetPasswordKey);

}