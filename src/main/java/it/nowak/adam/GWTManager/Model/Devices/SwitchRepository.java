package it.nowak.adam.GWTManager.Model.Devices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SwitchRepository extends JpaRepository <Switch,Long>{
}


