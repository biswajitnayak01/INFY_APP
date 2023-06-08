package com.infosys.app.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.infosys.app.entity.Rooms;
@Repository
public interface RoomRepository extends JpaRepository<Rooms,Integer> {

}
