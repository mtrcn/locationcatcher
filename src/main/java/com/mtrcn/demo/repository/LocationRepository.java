package com.mtrcn.demo.repository;

import com.mtrcn.demo.domain.LocationMessage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: mtrcn
 * Date: 5/5/13
 * Time: 4:35 PM
 * To change this template use File | Settings | File Templates.
 */
public interface LocationRepository extends JpaRepository<LocationMessage, Long> {

}
