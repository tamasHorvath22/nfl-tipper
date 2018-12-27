package com.codecool.api;


//@RestController
//public class JoinLeagues extends AbstractController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private LeagueService leagueService;
//
//    @PostMapping("/join-league")
//    @Transactional
//    public ResponseEntity<String> joinLeague(@RequestParam Integer leagueId) {
//        HttpSession session = getHttpSession();
//        League league = leagueService.findById(leagueId);
//        User user = (User) session.getAttribute("loggedInUser");
//        user = userService.getUserById(user.getId());
////        user.addToLeagueList(league);
//        userService.save(user);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//}
