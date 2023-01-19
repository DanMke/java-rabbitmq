import json
import pika
import requests
import time

ORDER_API_URL = 'http://localhost:8083'
ORDER_FILE_PATH = 'orders.json'
RABBIMQ_HOST = 'localhost'
QUEUE_NAME = 'order.queue'
EXCHANGE_NAME = 'order.exchange'
ROUTING_KEY = 'order.routingkey'

f = open(ORDER_FILE_PATH)
  
fileData = json.load(f)

for i in fileData:
  print(i)

f.close()

connection = pika.BlockingConnection(pika.ConnectionParameters(host=RABBIMQ_HOST))

channel = connection.channel()

channel.queue_declare(queue=QUEUE_NAME, durable=True)

for i in fileData:
  channel.basic_publish(exchange=EXCHANGE_NAME,
                    routing_key=ROUTING_KEY,
                    body=json.dumps(i))
  print(" [x] Sent %r" % i)

connection.close()

time.sleep(5)

r = requests.get(url = ORDER_API_URL + '/orders')
print()
print('All Orders: ')
print(r.json())
print()

r = requests.get(url = ORDER_API_URL + '/orders/1001')
print()
print('Order 1001: ')
print(r.json())
print()

r = requests.get(url = ORDER_API_URL + '/orders/1001/value')
print()
print('Get Order 1001 Total Value: ')
print(r.json())
print()

r = requests.get(url = ORDER_API_URL + '/customers/1/orders')
print()
print('Get Customer 1 Orders: ')
print(r.json())
print()

r = requests.get(url = ORDER_API_URL + '/customers/1/orders/quantity')
print()
print('Get Customer 1 Orders Quantity: ')
print(r.json())
print()
