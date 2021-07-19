package entity;

public class Requirements {

		private String name;
		private String email;
		private String id;
		private String type;
		private String rtype;
		private String comment;
		private String ogname;
		private String ogemail;
		private String status;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getRtype() {
			return rtype;
		}
		public void setRtype(String rtype) {
			this.rtype = rtype;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
		public String getOgname() {
			return ogname;
		}
		public void setOgname(String ogname) {
			this.ogname = ogname;
		}
		public String getOgemail() {
			return ogemail;
		}
		public void setOgemail(String ogemail) {
			this.ogemail = ogemail;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Requirements(String name, String email, String id, String type, String rtype, String comment,
				String ogname, String ogemail, String status) {
			
			this.name = name;//9
			this.email = email;
			this.id = id;
			this.type = type;
			this.rtype = rtype;
			this.comment = comment;
			this.ogname = ogname;
			this.ogemail = ogemail;
			this.status = status;
		}
		@Override
		public String toString() {
			return "Requirements [name=" + name + ", email=" + email + ", id=" + id + ", type=" + type + ", rtype="
					+ rtype + ", comment=" + comment + ", ogname=" + ogname + ", ogemail=" + ogemail + ", status="
					+ status + "]";
		}
		public Requirements(String name, String email, String type) {
			this.name = name;//3
			this.email = email;
			this.type = type;
		}
		public Requirements(String name, String rtype, String ogname, String status) {
			
			this.name = name;//4
			this.rtype = rtype;
			this.ogname = ogname;
			this.status = status;
		}
public Requirements(String name, String rtype,String comment, String ogname,String ogemail, String status) {
			
			this.name = name;//4
			this.rtype = rtype;
			this.comment = comment;
			this.ogname = ogname;
			this.ogemail = ogemail;
			this.status = status;
		}
		public Requirements(String name, String email, String type, String rtype, String comment, String ogname,
				String ogemail, String status) {
			
			this.name = name;//8
			this.email = email;
			this.type = type;
			this.rtype = rtype;
			this.comment = comment;
			this.ogname = ogname;
			this.ogemail = ogemail;
			this.status = status;
		}
		public Requirements(String name, String email, String type, String rtype, String comment) {
			this.name = name;//5
			this.email = email;
			this.type = type;
			this.rtype = rtype;
			this.comment = comment;
		}
		public Requirements(String name, String email, String type, String rtype, String ogname, String ogemail,
				String status) {
			//7
			this.name = name;
			this.email = email;
			this.type = type;
			this.rtype = rtype;
			this.ogname = ogname;
			this.ogemail = ogemail;
			this.status = status;
		}
		
		

}
