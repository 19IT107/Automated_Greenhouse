#include <SimpleDHT.h>

//for DHT11 
//VCC: 5V 
//GND: GND
//DATA: 2
int pinDHT11 = 2;
SimpleDHT11 dht11(pinDHT11);

//for Soil-Moisture
//VCC: 5V
//GND: GND
//DATA: A0
int sensorPin = A0;
int sensorValue;

void setup() 
{
  Serial.begin(9600);
}

void loop()
{
  // start
  Serial.println("=================================");
//---------------------------------------------------------------------------------------------------------------------------------------- 
  //temp-humidity
  byte temperature = 0;
  byte humidity = 0;
  int err = SimpleDHTErrSuccess;
  if ((err = dht11.read(&temperature, &humidity, NULL)) != SimpleDHTErrSuccess) 
  {
    Serial.print("Read DHT11 failed, err="); Serial.print(SimpleDHTErrCode(err));
    Serial.print(","); Serial.println(SimpleDHTErrDuration(err)); delay(1000);
    return;
  }
  
  Serial.print("Temperature and Relative-Humidity: ");
  Serial.print((int)temperature); Serial.print(" °C, "); 
  Serial.print((int)humidity); Serial.println(" %");
  delay(1500);
//----------------------------------------------------------------------------------------------------------------------------------------
  //soil-moist
  sensorValue = analogRead(sensorPin); 
  //Serial.print(sensorValue);
  float moisture_percentage = ( 100 - ( (sensorValue/1023.00) * 100 ) ); 
  Serial.print("Moisture Percentage = "); 
  Serial.print(moisture_percentage); 
  Serial.print("%\n");
  delay(1500);
//----------------------------------------------------------------------------------------------------------------------------------------
  //light-intensity
  int analogValue = analogRead(A1);

  Serial.print("Light intensity:");
  //Serial.print(analogValue);  

  if (analogValue < 10) {
    Serial.println(" - Dark");
  } else if (analogValue < 200) {
    Serial.println(" - Dim");
  } else if (analogValue < 500) {
    Serial.println(" - Light");
  } else if (analogValue < 800) {
    Serial.println(" - Bright");
  } else {
    Serial.println(" - Very bright");
  }
  delay(1500);
}
