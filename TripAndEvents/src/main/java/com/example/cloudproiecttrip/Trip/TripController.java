package com.example.cloudproiecttrip.Trip;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class TripController {
    private TripService tripService;
    private TripMapper tripMapper;

    public TripController(TripService tripService, TripMapper tripMapper) {
        this.tripService = tripService;
        this.tripMapper = tripMapper;
    }

    @PostMapping("{idUser}/trip")
    public TripDTO saveTrip(@Valid @RequestBody TripDTO tripRequest, @PathVariable("idUser") Long id){
        Trip tripHelp = tripMapper.dtoToEntity(tripRequest);
        TripDTO tripDTO = tripService.saveTrip(tripHelp, id);
        return tripDTO;
    }

//    @PostMapping("trips/{idTrip}/{idUser}")
//    public String addUserToTrip(@PathVariable("idTrip") Long idTrip, @PathVariable("idUser") Long idUser){
//        User username = tripService.addUserToTrip(idTrip, idUser);
//        if(username == null){
//            return "Userul nu a fost gasit!";
//        }
//        return "Userul " + username.getSurname() + " " + username.getName() + " a fost adaugatla aceasta excursie.";
//    }

    @GetMapping("trips/{id}")
    public TripDTO getTrip(@PathVariable Long id){
        return tripMapper.entityToDto(tripService.getTrip(id));
    }

    //    @GetMapping("/{name}")
//    public List<TripDTO> getTrip_name(@PathVariable String name){
//        List<Trip> tripsFound = userService.getTrip_name(name);
//        List<TripDTO> tripsDTO = new ArrayList<>();
//        for(Trip trip: tripsFound){
//            userMapper.entityToDto(trip);
//        }
//        return tripsDTO;
//    }

    @GetMapping("trips")
    public List<TripDTO> getAllTrips(){
        List<Trip> tripsList = tripService.getAllTrips();
        List<TripDTO> tripsDTOlist = new ArrayList<>();
        for(Trip trip:tripsList){
            tripsDTOlist.add(tripMapper.entityToDto(trip));
        }
        return tripsDTOlist;
    }

    @DeleteMapping("trips/{id}")
    public String deleteTrip(@PathVariable Long id){
        if(tripService.deleteTrip(id))
            return "Excursia a fost stearsa.";
        return  "Excursia nu a fost gasita.";
    }

//    @GetMapping("trips/{idTrip}/participants")
//    public List<UserCleanDTO> getParticipants(@PathVariable Long idTrip){
//        List<User> users = tripService.getParticipants(idTrip);
//        List<UserCleanDTO> usersDTO = new ArrayList<>();
//        for(User user: users){
//            usersDTO.add(new UserCleanDTO(user.getName(), user.getSurname(), user.getEmail(), user.getDescription(),user.getAge()));
//        }
//        return usersDTO;
//    }
}
