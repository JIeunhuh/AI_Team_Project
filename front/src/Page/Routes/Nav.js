// Nav 바
import {Link} from 'react-router-dom'

export function Nav() {
  return (
    <nav className="w-full h-[70px] fixed z-50 border border-black flex justify-between items-center">
      <div>
        <Link to="/">
          <p>logo</p>
        </Link>
      </div>
      <div className="flex items-center justify-center">
        <Link to="/static">
          <p className="w-[120px] h-full text-2xl text-center align-middle text-black">통계</p>
        </Link>
        <Link to="/result">
          <p className="w-[120px] h-full text-2xl text-center align-middle text-black">자료 조회</p>
        </Link>
        <Link to="/result">
          <p className="w-[120px] h-full text-2xl text-center align-middle text-black">고객센터</p>
        </Link>
      </div>
      <div className="flex items-center justify-end">
        <Link to="/login">
          <p className="w-[120px] h-full text-2xl text-center align-middle text-black">로그인</p>
        </Link>
        <Link to="/signup">
          <p className="w-[120px] h-full text-2xl text-center align-middle text-black">회원가입</p>
        </Link>
      </div>
    </nav>
  )
}
