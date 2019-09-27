package org.thatbug.whale.core.secure.provider;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.thatbug.whale.core.secure.constant.SecureConstant;

/**
 * ClientDetailsServiceImpl
 *
 * @author qzl
 * @date 15:30 2019/9/17
 */
@AllArgsConstructor
public class ClientDetailsServiceImpl implements IClientDetailsService {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public IClientDetails loadClientByClientId(String clientId) {
        try {
            return jdbcTemplate.queryForObject(SecureConstant.DEFAULT_SELECT_STATEMENT, new String[]{clientId}, new BeanPropertyRowMapper<>(ClientDetails.class));
        } catch (Exception ex) {
            return null;
        }
    }

}
