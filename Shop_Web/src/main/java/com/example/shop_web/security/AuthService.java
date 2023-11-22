//package com.example.shop_web.security;
//
//import com.example.shop_web.domain.User;
//import com.example.shop_web.domain.enumaration.ERole;
//import com.example.shop_web.repository.UserRepository;
//import com.example.shop_web.security.auth.request.RegisterRequest;
//import com.example.shop_web.util.AppUtil;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.validation.BindingResult;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//@AllArgsConstructor
//public class AuthService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    private final PasswordEncoder passwordencode;
//
//    public void register (RegisterRequest request) {
//        var user = AppUtil.mapper.map(request, User.class);
//        user.setRole(ERole.ROLE_USER);
//        user.setPassword(passwordencode.encode(user.getPassword()));
//        userRepository.save(user);
//    }
//
//    public boolean checkUserNameOrPhoneOrEmail (RegisterRequest request, BindingResult result) {
//        boolean check = false;
//        if (userRepository.existsByUserNameIgnoreCase(request.getUserName())) {
//            result.rejectValue("userName", "userName", "Tên người dùng đã tồn tại!");
//            check = true;
//        }
//        if (userRepository.existsByEmailIgnoreCase(request.getEmail())) {
//            result.rejectValue("email", "email", "Email đã tồn tại!");
//            check = true;
//        }
//        if (userRepository.existsByPhone(request.getPhone())) {
//            result.rejectValue("phone", "phone", "Số điện thoại đã tồn tại!");
//            check = true;
//        }
//        if (userRepository.existsByAddress(request.getAddress())) {
//            result.rejectValue("address", "address", "Địa chỉ đã tồn tại!");
//            check = true;
//        }
//
//        return check;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        User user = userRepository.findByUserNameIgnoreCaseOrEmailIgnoreCaseOrPhone(userName,userName,userName)
//                .orElseThrow(() -> new UsernameNotFoundException("User not Exist") );
//        var role = new ArrayList<SimpleGrantedAuthority>();
//        role.add(new SimpleGrantedAuthority(user.getRole().toString()));
//        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), role);
//    }
//    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
//        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
//        return authorities;
//    }
//
//}
