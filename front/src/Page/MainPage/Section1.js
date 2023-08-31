import papercup from '../../images/yellow-cups-6576738_1280_1.png'
import {Icon} from '../../Component'

export function Section1() {
  return (
    <div className="relative top-0 flex items-center justify-center w-full h-screen">
      <img src={papercup} className="absolute top-0 object-cover w-full h-full" />
      <p className="w-[550px] h-[198px] absolute left-[265px] top-[388px] text-[99px] text-left text-[#46a46c]">
        <span className="w-[550px] h-[198px] text-[99px] text-left text-[#46a46c] font-porter-sans">ECO</span>
        <br />
        <span className="w-[550px] h-[198px] text-[99px] text-left text-[#46a46c]">TRACE</span>
      </p>
      <p className="absolute left-[845px] top-[388px] text-left text-white">
        <span className="text-[38px] font-semibold text-left text-white">Tracing</span>
        <span className="text-[40px] text-left text-white"> </span>
        <span className="text-[34px] font-light text-left text-white">the Green Path of</span>
        <br />
        <span className="text-[38px] font-semibold text-left text-white">Recycling</span>
      </p>
      <Icon name="arrow_downward" className="absolute text-3xl font-bold bottom-6 animate-bounce" />
    </div>
  )
}
