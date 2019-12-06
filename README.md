# AWSLambda
Recibe la peticion de una funcion lambda ligada a un resource de api gateway

# Generate de jar to aws deploy
mvn clean package shade:shade

# Ejemplo de json de prueba

{
		"total": 1,
		"data": [
			{
				"id": "8995c40f-1c3a-48d0-98ee-bbc603622a91",
				"correlationId": "...",
				"destination": "5411900000000",
				"origin": "5411900000000",
				"campaignId": 100,
				"campaignAlias": "...",
				"flowId": "...",
				"extraInfo": "...",
				"sent": true,
				"sentStatusCode": 1,
				"sentStatus": "sent status",
				"sentDate": "2017-12-18T17:09:31.891Z",
				"sentAt": 1513616971891,
				"delivered": true,
				"deliveredStatusCode": 1,
				"deliveredStatus": "delivered status",
				"deliveredDate": "2017-12-18T17:09:31.891Z",
				"deliveredAt": 1513616971891,
				"read": true,
				"readDate": "2017-12-18T17:09:31.891Z",
				"readAt": 1513616971891,
				"updatedDate": "2017-12-18T17:09:31.891Z",
				"updatedAt": 1513616971891
			}
		],
		"clientInfo": {
			"customerId": 42,
			"subAccountId": 1291,
			"userId": 1
		}
}

