import requests
import BeautifulSoup

session=requests.session()
url = raw_input("Enter a website to extract the URL's from: ")
req=session.get(url,verify=False)
doc=BeautifulSoup.BeautifulSoup(req.content)
ls=[]
for i in doc.findAll('p'):
	print i.text
	
