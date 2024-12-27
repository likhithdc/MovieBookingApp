package com.moviebooking.app;

import com.moviebooking.app.model.Cinema;
import com.moviebooking.app.model.Movie;
import com.moviebooking.app.model.Screen;
import com.moviebooking.app.model.User;
import com.moviebooking.app.repository.CinemaRepository;
import com.moviebooking.app.repository.MovieRepository;
import com.moviebooking.app.repository.ScreenRepository;
import com.moviebooking.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;


@Component
public class MovieInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private MovieRepository movieRepository;

    public MovieInitializer(UserRepository userRepository, ScreenRepository screenRepository, MovieRepository movieRepository, CinemaRepository cinemaRepository) {
        this.userRepository = userRepository;
        this.screenRepository = screenRepository;
        this.movieRepository = movieRepository;
        this.cinemaRepository = cinemaRepository;
    }

    @Autowired
    private ScreenRepository screenRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0 && movieRepository.count() == 0 && screenRepository.count() == 0 && cinemaRepository.count() == 0) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            // Insert default users
            User user1 = new User();
            user1.setName("likhith");
            String encodedPass = encoder.encode("password");
            user1.setPassword(encodedPass);
            user1.setEmail("likhithdc@gmail.com");
            userRepository.save(user1);
            User user2 = new User();
            user2.setName("Jane Smith");
            String encodedPass2 = encoder.encode("password");
            user2.setPassword(encodedPass2);
            user2.setEmail("user@gmail.com");
            userRepository.save(user2);

            //Insert cinema
            Cinema cinema1 = new Cinema();
            cinema1.setName("Inox");
            cinemaRepository.save(cinema1);
            Cinema cinema2 = new Cinema();
            cinema2.setName("PVR");
            cinemaRepository.save(cinema2);

            // Insert default movies
            Movie movie1 = new Movie("Inception", LocalDate.of(2010, 7, 16), "Evening");
            Movie movie2 = new Movie("The Dark Knight", LocalDate.of(2008, 7, 18), "Night");
            Movie movie3 = new Movie("Interstellar", LocalDate.of(2014, 11, 7), "Morning");
            Movie movie4 = new Movie("Avatar", LocalDate.of(2009, 12, 18), "Afternoon");
            Movie movie5 = new Movie("The Matrix", LocalDate.of(1999, 3, 31), "Evening");
            movieRepository.saveAll(Arrays.asList(movie1, movie2, movie3, movie4, movie5));

            // Insert default screens
            Screen screen1 = new Screen();
            screen1.setType("IMAX");
            screen1.setCinema(cinema1);
            screen1.setMovie(movie1);
            screenRepository.save(screen1);
            Screen screen2 = new Screen();
            screen2.setType("3D");
            screen2.setCinema(cinema2);
            screen2.setMovie(movie2);
            screenRepository.save(screen2);
            Screen screen3 = new Screen();
            screen3.setType("Standard");
            screen3.setCinema(cinema1);
            screen3.setMovie(movie3);
            screenRepository.save(screen3);
            Screen screen4 = new Screen();
            screen4.setType("4DX");
            screen4.setCinema(cinema2);
            screen4.setMovie(movie4);
            screenRepository.save(screen4);
            Screen screen5 = new Screen();
            screen5.setType("Dolby Cinema");
            screen5.setCinema(cinema1);
            screen5.setMovie(movie5);
            screenRepository.save(screen5);
        }
    }

}