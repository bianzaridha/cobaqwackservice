/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.qwack.controller;


import id.qwack.model.Participant;
import id.qwack.service.ChannelService;
import id.qwack.service.ParticipantService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sabda
 */
@RestController
@RequestMapping(path = "/participant")
public class ParticipantController {
    
    @RequestMapping(method = RequestMethod.GET)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Participant.class)})
    public List<Participant> getAll(){
        ParticipantService participant = new ParticipantService();
        
        return participant.getAll();
    }
    
    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public Participant getById(@PathVariable("id") long id){
        ParticipantService participant = new ParticipantService();
        
        return participant.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String insert(@RequestBody Participant prtcpn){
        ParticipantService channel = new ParticipantService();
        channel.save(prtcpn);
        
        return "saved";
    }
    
    @RequestMapping(path = "/login/{username}/{password}", method = RequestMethod.GET)
    public Boolean login(@PathVariable("username") String username, @PathVariable("password") String password){
        System.out.println("user: "+ username);
        System.out.println("pass: "+ password);
        return true;
    }
}
