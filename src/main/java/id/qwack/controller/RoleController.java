/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.qwack.controller;


import id.qwack.model.Roles;
import id.qwack.service.RolesService;
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
@RequestMapping(path = "/role")
public class RoleController {
    
    @RequestMapping(method = RequestMethod.GET)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Roles.class)})
    public List<Roles> getAll(){
        RolesService role = new RolesService();
        
        return role.getAll();
    }
    
    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public Roles getById(@PathVariable("id") long id){
        RolesService role = new RolesService();
        
        return role.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String insert(@RequestBody Roles rl){
        RolesService role = new RolesService();
        role.save(rl);
        
        return "saved";
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") long id, @RequestBody Roles rl){
        RolesService role = new RolesService();
        role.delete(rl);
        
        return "Role ID "+ id +" deleted";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody Roles rl){
        RolesService role = new RolesService();
        role.update(rl);
        
        return "Role ID "+ rl.getId() +" updated";
    }
}
