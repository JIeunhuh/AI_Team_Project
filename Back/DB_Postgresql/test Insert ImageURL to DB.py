# Img url ~> insert DB
# image 경로 api로 boot에 넘겨주기
from flask import Flask, request, jsonify, send_file
# from flask_sqlalchemy import SQLAlchemy
import psycopg2
import os
import re

app = Flask(__name__)

# DB Connect
def connectDB():
    return psycopg2.connect(
        dbname='AI_resultSet_test',
        user='postgres',
        host='localhost',
        password='tiger',
        port=5432
    )
    
image_dir = 'C:\AI_Result_img'  # 이미지 파일이 있는 폴더 경로 입력
    
@app.route('/update_image', methods=["PUT"])
def update_image():
    try:
     

      conn = connectDB()
      cur = conn.cursor()
      
    # img file 가져오기(각 레코드에 맞춰 url 넣어야 함 ; enumerate 사용 !)
      for idx, filename in enumerate(os.listdir(image_dir), start=3600):
          if filename.endswith('.jpg') or filename.endswith('.png'):
              # image_path = os.path.join(image_dir, filename)
              image_url = f'http://localhost:8080/images/{filename}'
              
              # Insert ImageURL to DB(파라미터가 하나일때도 쉼표 써야함 ! ; 파라미터를 튜플로 전달하기 때문)
              cur.execute('update total_recycle set img_url = %s where detect_log_id=%s', (image_url, idx))
    
            # 
      conn.commit()
    #   close DB
      conn.close()
      
      response = {'message': 'Image URLs updated successfully'}
      return jsonify(response), 200
  
# exception handling
    except Exception as e:
      response = {'message': 'Error occurred', 'error': str(e)}
      return jsonify(response), 500

# image url 등록 (해당 이미지 파일 반환)   
@app.route('/images/<filename>')
def get_image(filename):
    
    image_path = os.path.join(image_dir, filename)
    return send_file(image_path, mimetype='image/png')  # 이미지 포맷에 맞게 mimetype 설정
    
    
if __name__ == '__main__':
    app.run(host='localhost', port=8080, debug=True)
