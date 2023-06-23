package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HerokuappExpectedBodyPOJO {

    private int bookingId;
    private BookingPOJO booking;
}
