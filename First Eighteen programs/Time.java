package io.github.xieyezi;
class Time {
        private int hour,minute,second;
        public Time() {
			this(System.currentTimeMillis());
		}
        public Time(long num) {
        	second = (int)((num/1000)%60);
        	minute = (int)((num/1000/60)%60);
        	hour = (int)((num/1000/60/60)%24);
        }
       public Time(int hour,int minute,int second) {
    	  this.hour = hour;
    	  this.minute = minute;
    	  this.second = second;
       }
		public int getHour() {
			return hour;
		}
		public int getMinute() {
			return minute;
		}
		public int getSecond() {
			return second;
		}
	    public void setTime(long elapseTime){
	    	 second = (int)((elapseTime/1000)%60);
	      	minute = (int)((elapseTime/1000/60)%60);
	      	hour = (int)((elapseTime/1000/60/60)%24);
	      }
	    public static void main(String[] args) {
	    	  Time time1 = new Time();
	    	  Print(time1);
	    	  Time time2 = new Time(555550000);
	    	  Print(time2);
	      }
	      public static void Print(Time time) {
	    	  System.out.println(time.getHour()+":"+time.getMinute()+":"+time.getSecond());
	      }
}