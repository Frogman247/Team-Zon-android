# Team-Zon-android
I made this android app to act as an interface between the solar vehicle project of my college of which I am a part. #It has a login screen through which the team members can access the app by giving the proper authentications. 
Data is transmitted in realtime from the car through a sim808 GPRS/GSM/GPS module via arduino. This module sends messages regarding the car's location, ultrasonic sensor data, temperature sensor data, driver attention system data via SMS to the app and the app has 4 different activities to dispaly them such as 
1. mapactivity- displays the realtime location of the car by extracting the latitude and longitude from the SMS received and displaying them on google maps. 
2. parkactivity- displays the ultrasonic sensor data received via SMS ie. the distance from the nearest object as wellas a aprogress bar. 
3. headactivity- displays the sensor data from accelerometer received via SMS and displays the head position of driver. 
4. tempactivity- It will display the temperature sensor data received via SMS on the app
