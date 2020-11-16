package it.nowak.adam.GWTManager.Controller;

import it.nowak.adam.GWTManager.Model.Locations.Floor;
import it.nowak.adam.GWTManager.Model.Locations.Room;
import it.nowak.adam.GWTManager.Model.Locations.RoomRepository;
import it.nowak.adam.GWTManager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/rooms")
    public List<Room> getAllFloors() {return roomRepository.findAll();}
    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomsById(@PathVariable(value = "id") Long roomId) throws ResourceNotFoundException {
        it.nowak.adam.GWTManager.Model.Locations.Room room =
                roomRepository
                        .findById(roomId)
                        .orElseThrow(() -> new ResourceNotFoundException("Room not found on :: " + roomId));
        return ResponseEntity.ok().body(room);
    }
    @PostMapping("/rooms")
    public Room createRoom(@Valid @RequestBody Room room) { return roomRepository.save(room);}
    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> updateRoom(

            @PathVariable(value = "id") Long roomId, @Valid @RequestBody Room roomDetails)
            throws ResourceNotFoundException {
        Room room =
                roomRepository
                        .findById(roomId)
                        .orElseThrow(() -> new ResourceNotFoundException("Room not found on :: " + roomId));
        room.setNumber(roomDetails.getNumber());
        room.setFloor(roomDetails.getFloor());
        final Room updatedRoom = roomRepository.save(room);
        return ResponseEntity.ok(updatedRoom);
    }
    @DeleteMapping("/rooms/{id}")
    public Map<String, Boolean> deleteRoom(@PathVariable(value = "id") Long roomId) throws Exception {
        Room room =
                roomRepository
                        .findById(roomId)
                        .orElseThrow(() -> new ResourceNotFoundException("Room not found on :: " + roomId));
        roomRepository.delete(room);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

