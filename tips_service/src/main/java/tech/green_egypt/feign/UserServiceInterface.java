package tech.green_egypt.feign;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("user-service")
public interface UserServiceInterface {
}
