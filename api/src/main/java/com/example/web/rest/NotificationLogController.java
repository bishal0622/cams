package com.example.web.rest;

import com.example.domain.NotificationLog;
import com.example.service.NotificationLogService;
import com.example.service.dto.NotificationLogDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by BiSAl MhRzn on 12/23/2016.
 */
@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("/api")
public class NotificationLogController {
    @Inject
    NotificationLogService notificationLogService;

    @RequestMapping(value="/notification",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<?> insertNotification(@RequestBody NotificationLogDTO notificationLogDTO, HttpServletRequest httpServletRequest){
        System.out.println("notificationController");
        System.out.println(notificationLogDTO.toString());

        HttpHeaders textPlainheaders = new HttpHeaders();
        textPlainheaders.setContentType(MediaType.TEXT_PLAIN);

        NotificationLog notificationLog=notificationLogService.saveNotificationLog(notificationLogDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @RequestMapping(value = "/notification",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAllNotification()
            throws URISyntaxException {

        List<NotificationLog> val=notificationLogService.getAllNotification();

        System.out.println(val);
        return new ResponseEntity<>(val, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/notification",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<NotificationLogDTO> updateNotification(@RequestBody NotificationLogDTO notificationLogDTO) {
        notificationLogService.updateNotification(notificationLogDTO.getId(),notificationLogDTO.getNotificationDatetime(),notificationLogDTO.getAppointmentId(),notificationLogDTO.getConfirmedDatetime(),notificationLogDTO.getAppointmentByAppointmentId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/notification/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getNotifications(@PathVariable Integer id)
            throws URISyntaxException {
        System.out.println("get one user");

        return notificationLogService.getNotificationById(id)
                .map(notificationLogDTO -> new ResponseEntity<>(notificationLogDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/notification/{id}",
            method= RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void deleteNotification(@PathVariable Integer id) {
        System.out.println("delete");
        notificationLogService.deleteNotification(id);
    }
}
