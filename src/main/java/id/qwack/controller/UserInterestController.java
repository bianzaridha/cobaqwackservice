/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.qwack.controller;

import id.qwack.model.UserInterest;
import id.qwack.service.UserInterestService;
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
@RequestMapping(path = "/interest")
public class UserInterestController {
    
    @RequestMapping(method = RequestMethod.GET)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = UserInterest.class)})
    public List<UserInterest> getAll(){
        UserInterestService userInterest = new UserInterestService();
        
        return userInterest.getAll();
    }
    
    @RequestMapping(path = "participant/{id}", method = RequestMethod.GET)
    public List<UserInterest> getAllByParticipant(@PathVariable("id") long id){
        UserInterestService userInterest = new UserInterestService();
        
        return userInterest.getAllByParticipant(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String insert(@RequestBody UserInterest ui){
        UserInterestService userInterest = new UserInterestService();
        userInterest.save(ui);
        
        return "saved";
    }
    
    @RequestMapping(path = "participant/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") long id, @RequestBody UserInterest ui){
        UserInterestService userInterest = new UserInterestService();
        userInterest.delete(ui);
        
        return "Tag ID "+ id +" deleted";
    }
    
}
