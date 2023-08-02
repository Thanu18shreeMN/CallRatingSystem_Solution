package callrating;
class CallRating {
 String callId;
 int callDuration;
 double callQuality;
 String ratingCategory;

 public CallRating(String callId, int callDuration, double callQuality) {
     this.callId = callId;
     this.callDuration = callDuration;
     this.callQuality = callQuality;
 }

 public void setRatingCategory(String ratingCategory) {
     this.ratingCategory = ratingCategory;
 }

 @Override
 public String toString() {
     return "Call ID: " + callId + ", Duration: " + callDuration + " minutes, Quality: " + callQuality
             + ", Rating Category: " + ratingCategory;
 }
}
public class CallRatingSystem {
 public static CallRating[] rateCalls(int[] callDurations, double[] callQualities) {
     if (callDurations == null || callQualities == null || callDurations.length != callQualities.length) {
         throw new IllegalArgumentException("Invalid input arrays.");
     }

     CallRating[] callRatings = new CallRating[callDurations.length];

     for (int i = 0; i < callDurations.length; i++) {
         double ratingScore = callQualities[i] / callDurations[i];
         String ratingCategory;
         
         if (ratingScore >= 0.08) {
             ratingCategory = "Excellent";
         } else if (ratingScore >= 0.05) {
             ratingCategory = "Good";
         } else {
             ratingCategory = "Average";
         }

         CallRating callRating = new CallRating("Call" + (i + 1), callDurations[i], callQualities[i]);
         callRating.setRatingCategory(ratingCategory);
         callRatings[i] = callRating;
     }

     return callRatings;
 }

 public static void main(String[] args) {
     int[] callDurations = {5,10,7,8,15};
     double[] callQualities = {0.35,0.48,0.21,0.12,0.30};

     CallRating[] callRatings = rateCalls(callDurations, callQualities);

     for (CallRating callRating : callRatings) {
         System.out.println(callRating);
     }
 }
}
