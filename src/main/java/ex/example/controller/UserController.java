package ex.example.controller;

import ex.example.dao.UserRepository;
import ex.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/getall")
    public Flux<User> getAll(){
        return userRepository.findAll();
    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    @GetMapping("/getById/{id}")
    public Mono<User> getById(@PathVariable Integer id){
        Mono<User> user = userRepository.findById(id);
//        if(user == null){
//            throw new RuntimeException("用户不存在！");
//        }
        return user;
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/add")
    public Mono<User> create(@RequestBody User user){
        return userRepository.save(user);
    }

    /**
     * 修改用户信息
     * @param user
     * @param id
     * @return
     */
    @PutMapping("/update/{id}")
    public Mono<User> updateUser(@RequestBody User user,@PathVariable Integer id){
        return userRepository.findById(id).map((s) -> {
            s.setName(user.getName());
            return s;
        }).flatMap(s -> userRepository.save(s));
    }

    /**
     * 根据id删除用户
     * @param id
     */
    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteUser(@PathVariable Integer id){
        return userRepository.deleteById(id);
    }
}
