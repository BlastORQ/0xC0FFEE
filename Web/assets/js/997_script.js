//USEFUL FUNCTIONS
!function(){function t(t){this.element=t}var e=function(t){return new RegExp("(^| )"+t+"( |$)")},n=function(t,e,n){for(var i=0;i<t.length;i++)e.call(n,t[i])};t.prototype={add:function(){n(arguments,function(t){this.contains(t)||(this.element.className+=" "+t)},this)},remove:function(){n(arguments,function(t){this.element.className=this.element.className.replace(e(t),"")},this)},toggle:function(t){return this.contains(t)?(this.remove(t),!1):(this.add(t),!0)},contains:function(t){return e(t).test(this.element.className)},replace:function(t,e){this.remove(t),this.add(e)}},"classList"in Element.prototype||Object.defineProperty(Element.prototype,"classList",{get:function(){return new t(this)}}),window.DOMTokenList&&null==DOMTokenList.prototype.replace&&(DOMTokenList.prototype.replace=t.prototype.replace)}();


window.Onori = {
	log: function(){
		Onori.console.apply(console.log, arguments);
	},
	warn: function(){
		Onori.console.apply(console.warn, arguments);
	},
	console: function(){
		var arr = [];
		var notifStr = "";
		for(key in arguments){
			var t = arguments[key];
			notifStr += arguments[key].toString() + " ";
			var current = [];
			if(typeof t == "string"){
				t = t.replace(/([A-Z]+):{(.+?)}/g, (a, b, c)=>{
					if(b == "TITLE"){
						while(c.length < 56)c=" "+c+" ";
						if(c.length > 56 && c[0] == " ")c = c.substr(1);;
						c = "%c %c %c "+ c +" %c %c ";
						current.push("background: #9575cd");
						current.push("background: #673ab7");
						current.push("color: #ffffff; background: #512da8;");
						current.push("background: #673ab7");
						current.push("background: #9575cd");
						return c;
					}else{
						var style = "border-radius: 2px; padding: 1px 4px; line-height: 1.5em; ";
						switch(b.toLowerCase()){
							case "r":current.push("color: #000000; background: #ffb3ba;"+style);break;
							case "o":current.push("color: #000000; background: #ffdfba;"+style);break;
							case "y":current.push("color: #000000; background: #ffffba;"+style);break;
							case "g":current.push("color: #000000; background: #baffc9;"+style);break;
							case "b":current.push("color: #000000; background: #bae1ff;"+style);break;
							case "w":current.push("color: #ffffff; background: #000000;"+style);break;
							default:current.push("color: #000000; background: #ffffff;"+style);break;
						}
						current.push("color: #000000; background: #ffffff;");
						return "%c"+c+"%c";
					}
				});
			}
			current.unshift(t);
			arr = arr.concat(current);
		}
		this.apply(window, arr);
		if(Onori.config("displayPoplog"))Onori.notif(notifStr);
	},
	notif: function(data){
		if(!Onori.notif.selector)Onori.notif.selector = Onori.uuid();
		var rootId = "notif-"+Onori.notif.selector;
		var root = document.querySelector("#"+rootId);
		if (!root) {
			root = document.createElement("div");
			root.id = rootId;
			root.innerHTML = `<style>
			#${rootId}{
				position:fixed;
				top:0;
				left:0;
				display:block;
				width:100%;
				max-width:100vw;
				height:auto;
				margin:0;
				padding:0;
				z-index:10000000000000
			}
			#${rootId}>div{
				display:block;
				box-sizing:border-box;
				width:100%;
				margin:0 0 2px;
				padding:8px;
				background:#fafafa;
				color:#000000;
				border-radius:2px;
				font-family:consolas;
				font-size: 18px;
				transition-duration:.5s;
				box-shadow:1px 2px 8px rgba(0,0,0,0.3)
			}
			#${rootId}>div.hidden{
				overflow:hidden;
				max-height:0;
				padding:0 8px;
				argin-bottom:0;
				opacity:0
			}
			#${rootId}>div>span{border-radius:2px;padding:0px 4px;line-height:1.5em}
			#${rootId}>div>span.${rootId}-R{color:#000000;background:#ffb3ba}
			#${rootId}>div>span.${rootId}-O{color:#000000;background:#ffdfba}
			#${rootId}>div>span.${rootId}-Y{color:#000000;background:#ffffba}
			#${rootId}>div>span.${rootId}-G{color:#000000;background:#baffc9}
			#${rootId}>div>span.${rootId}-B{color:#000000;background:#bae1ff}
			#${rootId}>div>span.${rootId}-W{color:#ffffff;background:#000000}
			#${rootId}>div>span.${rootId}-TITLE{
				display:block;
				color:#ffffff;
				background:#512da8;
				font-weight:bold;
				text-align:center
			}
			</style>`;
			document.body.appendChild(root);
		}
		var el = document.createElement("div");
		el.addEventListener("contextmenu", e => {
			el.className = "hidden";
			setTimeout(()=>el.outerHTML="", 1000);
			e.preventDefault();
		});
		el.innerHTML = data.toString().replace(/([A-Z]+):{(.+?)}/g, (a, b, c) => `<span class="${rootId}-${b}">${c}</span>`);
		root.appendChild(el);
		setTimeout(() => {
			el.className = "hidden";
			setTimeout(()=>el.outerHTML="", 1000);
		}, 6000);
	}, 
	hash: function (r){function t(r,t){return r<<t|r>>>32-t}function o(r){var t,o="";for(t=7;t>=0;t--)o+=(r>>>4*t&15).toString(16);return o}var e,n,a,h,C,c,f,i,d,g=new Array(80),s=1732584193,p=4023233417,u=2562383102,A=271733878,S=3285377520,m=(r=function(r){r=r.replace(/\r\n/g,"\n");for(var t="",o=0;o<r.length;o++){var e=r.charCodeAt(o);e<128?t+=String.fromCharCode(e):e>127&&e<2048?(t+=String.fromCharCode(e>>6|192),t+=String.fromCharCode(63&e|128)):(t+=String.fromCharCode(e>>12|224),t+=String.fromCharCode(e>>6&63|128),t+=String.fromCharCode(63&e|128))}return t}(r)).length,l=new Array;for(n=0;n<m-3;n+=4)a=r.charCodeAt(n)<<24|r.charCodeAt(n+1)<<16|r.charCodeAt(n+2)<<8|r.charCodeAt(n+3),l.push(a);switch(m%4){case 0:n=2147483648;break;case 1:n=r.charCodeAt(m-1)<<24|8388608;break;case 2:n=r.charCodeAt(m-2)<<24|r.charCodeAt(m-1)<<16|32768;break;case 3:n=r.charCodeAt(m-3)<<24|r.charCodeAt(m-2)<<16|r.charCodeAt(m-1)<<8|128}for(l.push(n);l.length%16!=14;)l.push(0);for(l.push(m>>>29),l.push(m<<3&4294967295),e=0;e<l.length;e+=16){for(n=0;n<16;n++)g[n]=l[e+n];for(n=16;n<=79;n++)g[n]=t(g[n-3]^g[n-8]^g[n-14]^g[n-16],1);for(h=s,C=p,c=u,f=A,i=S,n=0;n<=19;n++)d=t(h,5)+(C&c|~C&f)+i+g[n]+1518500249&4294967295,i=f,f=c,c=t(C,30),C=h,h=d;for(n=20;n<=39;n++)d=t(h,5)+(C^c^f)+i+g[n]+1859775393&4294967295,i=f,f=c,c=t(C,30),C=h,h=d;for(n=40;n<=59;n++)d=t(h,5)+(C&c|C&f|c&f)+i+g[n]+2400959708&4294967295,i=f,f=c,c=t(C,30),C=h,h=d;for(n=60;n<=79;n++)d=t(h,5)+(C^c^f)+i+g[n]+3395469782&4294967295,i=f,f=c,c=t(C,30),C=h,h=d;s=s+h&4294967295,p=p+C&4294967295,u=u+c&4294967295,A=A+f&4294967295,S=S+i&4294967295}return(d=[parseInt(o(s),16).toString(36),parseInt(o(p),16).toString(36),parseInt(o(u),16).toString(36),parseInt(o(A),16).toString(36),parseInt(o(S),16).toString(36)].join("")).toUpperCase()},
	
	qq: function(q){return document.querySelector(q);},
	qqq: function(q){return document.querySelectorAll(q);},
	rand: function(mi, ma){return Math.floor(Math.random() * (ma - mi + 1) + mi);},
	uuid: function(){
		function n(){
			return Math.floor(65536*(1+Math.random())).toString(16).substring(1);
		};
		return n()+n()+"-"+n()+"-"+n()+"-"+n()+"-"+n()+n()+n()
	},
	download: function(filename, data){
		var element = document.createElement('a');
		element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(data));
		element.setAttribute('download', filename);
		element.style.display = 'none';
		document.body.appendChild(element);
		element.click();
		setTimeout(()=>{
			document.body.removeChild(element);
		}, 200);
	},
	
	config: function(){
		if(arguments.length == 1){
			return Onori.config[arguments[0]];
		}else if(arguments.length == 2){
			return Onori.config[arguments[0]] = arguments[1];
		}
	},
	init: function(){
		for(var i=0; i<arguments.length; i++){
			if(typeof arguments[i] == "function")arguments[i]();
		}
	}
};
var rand = Onori.rand;
var randId = Onori.uuid;
var qq = Onori.qq;
var qqq = Onori.qqq;
var dl = Onori.download;
var _h = Onori.hash;

Onori.init(
	()=>{
		Onori.config("displayPoplog", false);
	}, 
	()=>{
		//Do smth here...
	}
);

function req(u, p = false){
	var t = "./connector.php?" + u;
	if (t.match(/\?/)) {
		t += '&rand='+randId();
	} else {
		t += '?rand='+randId();
	}
	
	var params = {
		credentials: "same-origin"
	};
	if(p){
		params.method = "POST",
		params.body = p
	}
	return fetch(t+'&t='+app.token, params).then(data => data.json())
	.then((data) => new Promise((ok, no) => {
		if(data.error && data.error == "login"){
			window.location = "./#s-login";
			//no("error");
		}else{
			ok(data);
		}
	}));
}




var app = {
	token: "0",
	isAdmin: false,
	tab: {},

	eventHandler: {
		params: {},
		add: function(k, f){
			app.eventHandler.params[k] = f;
		},
		callback: function(event){
			var target = event.target;
			var action = target.getAttribute("data-on-"+event.type) || "";
			action = action.split(" ");
			for(var i in action){
				var act = action[i];
				if(typeof app.eventHandler.params[act] == "function"){
					window.event = event;
					window.target = target;
					app.eventHandler.params[act]();
				}
			}
		}
	},
	
	services: {},
	
	init: function(param = {}, callback){
		app.token = localStorage.getItem("token") || "DG2sp6RWvi24MDj3";
		app.isAdmin = !!(app.token[5]%2);

		document.addEventListener("change", app.eventHandler.callback, 0);
		document.addEventListener("keyup", app.eventHandler.callback, 0);
		document.addEventListener("click", app.eventHandler.callback, 0);
		
		if(app.isAdmin){
			if(qq("#forAdmin"))qq("#forAdmin").style.display = "";
		}
		
		if(typeof callback == "function"){
			callback();
		}
	}
}




/*
	EVENT LISTENERS
*/
app.eventHandler.add("clickBack", () => {
	var n = app.service.blocks.indexOf(document.querySelector("div.block:target").id);
	n--;
	if(n >= app.service.blocks.length){
		return;
	}
	if(n<0){
		window.location = "/";
	}
	if(n == app.service.blocks.length-1){
		qq("#btn-next").style.display = "none";
		qq("#btn-submit").style.display = "";
	}else{
		qq("#btn-next").style.display = "";
		qq("#btn-submit").style.display = "none";
	}
	
	if(n > -1){
		qq("#btn-back").disabled = false;
	}else{
		window.location = "./";
	}
	window.location.hash = app.service.blocks[n];
});

app.eventHandler.add("clickNext", () => {
	var n = app.service.blocks.indexOf(document.querySelector("div.block:target").id);
	if(document.querySelector("div.block:target").id == "s-login"){
		app.service.login.login(qq("#lo").value, qq("#pa").value);
		return;
	}
	n++;
	if(n<0 || n >= app.service.blocks.length){
		return;
	}
	if(n == app.service.blocks.length-1){
		qq("#btn-next").style.display = "none";
		qq("#btn-submit").style.display = "";
	}else{
		qq("#btn-next").style.display = "";
		qq("#btn-submit").style.display = "none";
	}
	
	if(n > -1){
		qq("#btn-back").disabled = false;
	}else{
		window.location = "./";
	}
	window.location.hash = app.service.blocks[n];
});