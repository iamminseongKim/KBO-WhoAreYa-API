from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.options import Options
from urllib.parse import unquote, urlparse, parse_qs
import time

# url 을 디코딩 하기 위한 함수
def decode_img_url(encoded_url):
    decoded_url = unquote(encoded_url)
    return decoded_url

# 선수 썸네일 url 을 호출 하기 위한 함수 
def extract_fname_from_url(url):
    parsed_url = urlparse(url)
    query_params = parse_qs(parsed_url.query)
    
    if 'fname' in query_params:
        return query_params['fname'][0]
    else:
        return None
    
def positon_make(position) :
    if position == '투수':
        return 'P'
    elif position == '포수':
        return 'C'
    elif position == '내야수':   
        return 'IF'
    else :
        return 'OF'

def type_make(type) :
    
    if type == '우투우타':
        return 0
    elif type == '우투좌타':
        return 1
    elif type == '우언우타':
        return 2
    elif type == '우언좌타':
        return 3
    elif type == '좌투우타':
        return 4
    elif type == '좌투좌타':
        return 5
    elif type == '좌언우타':
        return 6
    elif type == '좌언좌타':
        return 7
    elif type == '우투양타':
        return 8
    elif type == '좌투양타':
        return 9
    elif type == '양투우타':
        return 10
    elif type == '양투좌타':
        return 11
    else :  #양투양타
        return 12
    

options = Options()
options.add_experimental_option("detach", True)
options.add_experimental_option("excludeSwitches", ["enable-logging"])

driver = webdriver.Chrome(options=options)
urlList = [
    #'https://sports.daum.net/team/kbo/387/squad#0' ,    # 1. LG
    # 'https://sports.daum.net/team/kbo/394601/squad#0'  # 2. KT
    # 'https://sports.daum.net/team/kbo/384/squad#0'     # 3. SSG
    # 'https://sports.daum.net/team/kbo/172615/squad#0'  # 4. NC
    # 'https://sports.daum.net/team/kbo/385/squad#0',     # 5. 두산
    # 'https://sports.daum.net/team/kbo/389/squad#0',     # 6. KIA
    # 'https://sports.daum.net/team/kbo/386/squad#0',     # 7. 롯데 서xx 때문에 오류났다..
     'https://sports.daum.net/team/kbo/383/squad#0',     # 8. 삼성
     'https://sports.daum.net/team/kbo/390/squad#0',     # 9. 한화
     'https://sports.daum.net/team/kbo/382/squad#0'      # 10. 키움
]
results = []   
teamNum = 8
try:
  for url in urlList:
    driver.get(url)
    time.sleep(3)
    area  = driver.find_elements(By.XPATH, '//*[@id="viewSquad"]/div/div/div')

    for element in area: 
            element.click()
            tr = driver.find_elements(By.XPATH, '//*[@id="viewSquad"]/table/tbody/tr')
            seo = 0
            try: 
                for row in tr:
                    data = {}
                    name = row.find_elements(By.TAG_NAME, 'td')[1]
                    
                    postion = row.find_elements(By.TAG_NAME, 'td')[2]
                    height = row.find_elements(By.TAG_NAME, 'td')[3]
                    birthDate = row.find_elements(By.TAG_NAME, 'td')[5]
                    data['team_id'] = teamNum
                    data['name'] = name.text
                    data['position'] = positon_make(postion.text)
                    data['height'] = height.text
                    data['birth_date'] = birthDate.text
                    backNum = row.find_elements(By.TAG_NAME,'td')[0]
                    data['back_number'] = backNum.text

                    link = row.find_element(By.CLASS_NAME, 'info_player')
                    a_tag = link.find_element(By.TAG_NAME, 'a')   
                    src = a_tag.get_attribute('href')
                    driver.get(src)
                    type = driver.find_element(By.XPATH, '//*[@id="playerInfo"]/div[1]/div/div[1]/span[2]')
                    data['type'] = type_make(type.text)
                    results.append(data)
                    driver.back()   
            finally:
                continue
    teamNum += 1
                  
finally :
    driver.quit()
    import pandas as pd 
    import numpy as np 
    df = pd.DataFrame.from_records(results)
    df.to_excel('삼성 라이온즈 ~ 키움.xlsx')
    
 

